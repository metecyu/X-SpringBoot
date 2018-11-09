$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/monthteacher/list',
        datatype: "json",
        colModel: [			
			{ label: 'monthteacherid', name: 'monthteacherid', index: 'monthteacherid', width: 50, key: true },
			{ label: '期数编号', name: 'termid', index: 'termid', width: 80 }, 			
			{ label: '11:AF, 12:CF, 21:免费短训,22:收费短训', name: 'teacherid', index: 'teacherId', width: 80 }, 			
			{ label: '', name: 'unitprice', index: 'unitprice', width: 80 }, 			
			{ label: '', name: 'sumhour', index: 'sumhour', width: 80 }, 			
			{ label: '', name: 'sumprice', index: 'sumprice', width: 80 }, 			
			{ label: '', name: 'createtime', index: 'createTime', width: 80 }, 			
			{ label: '', name: 'updatetime', index: 'updateTime', width: 80 }, 			
			{ label: '', name: 'iseff', index: 'iseff', width: 80 }			
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
		monthteacher: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.monthteacher = {};
		},
		update: function (event) {
			var monthteacherid = getSelectedRow();
			if(monthteacherid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(monthteacherid)
		},
		saveOrUpdate: function (event) {
			var url = vm.monthteacher.monthteacherid == null ? "user/monthteacher/save" : "user/monthteacher/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.monthteacher),
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
			var monthteacherids = getSelectedRows();
			if(monthteacherids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "user/monthteacher/delete",
                    contentType: "application/json",
				    data: JSON.stringify(monthteacherids),
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
		getInfo: function(monthteacherid){
			$.get(baseURL + "user/monthteacher/info/"+monthteacherid, function(r){
                vm.monthteacher = r.monthteacher;
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