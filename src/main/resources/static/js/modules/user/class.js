$(function () {
	alert(1)
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/class/list',
        datatype: "json",
        colModel: [			
			{ label: 'classid', name: 'classid', index: 'classid', width: 50, key: true },
			{ label: '班级名称', name: 'classname', index: 'classname', width: 80 }, 			
			{ label: '22', name: 'classtype', index: 'classtype', width: 80 },
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
		class: {}
	},
	methods: {
		query: function () {

			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.class = {};
		},
		update: function (event) {
			var classid = getSelectedRow();
			if(classid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(classid)
		},
		saveOrUpdate: function (event) {
			var url = vm.class.classid == null ? "user/class/save" : "user/class/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.class),
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
			var classids = getSelectedRows();
			if(classids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "user/class/delete",
                    contentType: "application/json",
				    data: JSON.stringify(classids),
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
		getInfo: function(classid){
			$.get(baseURL + "user/class/info/"+classid, function(r){
                vm.class = r.class;
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