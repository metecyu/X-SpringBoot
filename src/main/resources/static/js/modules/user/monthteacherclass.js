$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/monthteacherclass/list',
        datatype: "json",
        colModel: [			
			{ label: 'mtmcid', name: 'mtmcid', index: 'mtmcId', width: 50, key: true },
			{ label: '月度教师课时主表id', name: 'monthteacherid', index: 'monthteacherid', width: 80 }, 			
			{ label: '班级编号', name: 'classid', index: 'classid', width: 80 }, 			
			{ label: '', name: 'classhour', index: 'classhour', width: 80 }			
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
		monthteacherclass: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.monthteacherclass = {};
		},
		update: function (event) {
			var mtmcid = getSelectedRow();
			if(mtmcid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(mtmcid)
		},
		saveOrUpdate: function (event) {
			var url = vm.monthteacherclass.mtmcid == null ? "user/monthteacherclass/save" : "user/monthteacherclass/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.monthteacherclass),
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
			var mtmcids = getSelectedRows();
			if(mtmcids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "user/monthteacherclass/delete",
                    contentType: "application/json",
				    data: JSON.stringify(mtmcids),
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
		getInfo: function(mtmcid){
			$.get(baseURL + "user/monthteacherclass/info/"+mtmcid, function(r){
                vm.monthteacherclass = r.monthteacherclass;
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