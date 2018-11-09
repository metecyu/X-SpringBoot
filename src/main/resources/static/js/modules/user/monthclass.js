$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/monthclass/list',
        datatype: "json",
        colModel: [			
			{ label: 'monthclassid', name: 'monthclassid', index: 'monthclassid', width: 50, key: true },
			{ label: '期数编号', name: 'termid', index: 'termid', width: 80 }, 			
			{ label: '班级编号', name: 'classid', index: 'classid', width: 80 }, 			
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
		monthclass: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.monthclass = {};
		},
		update: function (event) {
			var monthclassid = getSelectedRow();
			if(monthclassid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(monthclassid)
		},
		saveOrUpdate: function (event) {
			var url = vm.monthclass.monthclassid == null ? "user/monthclass/save" : "user/monthclass/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.monthclass),
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
			var monthclassids = getSelectedRows();
			if(monthclassids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "user/monthclass/delete",
                    contentType: "application/json",
				    data: JSON.stringify(monthclassids),
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
		getInfo: function(monthclassid){
			$.get(baseURL + "user/monthclass/info/"+monthclassid, function(r){
                vm.monthclass = r.monthclass;
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