$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/teacherprice/list',
        datatype: "json",
        colModel: [			
			{ label: '编号', name: 'teacherid', index: 'teacherId', width: 50, key: true },
			{ label: '姓名', name: 'teachername', index: 'teacherName', width: 80 },
			{ label: '单价', name: 'unitprice', index: 'unitprice', width: 80 },
			{ label: '类型', name: 'iscompanyCN', index: 'iscompany', width: 80 },
			{ label: '公司名称', name: 'companyname', index: 'companyname', width: 80 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		teacherprice: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.teacherprice = {iscompany:0};
		},
		update: function (event) {
			var teacherid = getSelectedRow();
			if(teacherid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(teacherid)
		},
		saveOrUpdate: function (event) {
			var url = vm.teacherprice.teacherid == null ? "user/teacherprice/save" : "user/teacherprice/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.teacherprice),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var teacherids = getSelectedRows();
			if(teacherids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "user/teacherprice/delete",
                    contentType: "application/json",
				    data: JSON.stringify(teacherids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(teacherid){
			$.get(baseURL + "user/teacherprice/info/"+teacherid, function(r){
                vm.teacherprice = r.teacherprice;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});