$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/monthteacher/list',
        datatype: "json",
        colModel: [
            { label: '编号', name: 'monthteacherid', index: 'monthteacherid', width: 30, key: true },
/*            { label: '期数编号', name: 'termid', index: 'termid', width: 80 },*/
            { label: '教师', name: 'teachername', index: 'teachername', width: 40 },
            { label: '单价', name: 'unitprice', index: 'unitprice', width: 40 },
            { label: '总课时', name: 'sumhour', index: 'sumhour', width: 80 },
            { label: '课酬100%', name: 'sumprice', index: 'sumprice', width: 80 },
            { label: '课酬实际', name: 'sumfactprice', index: 'sumfactprice', width: 80 },
            { label: '', name: 'createtime', index: 'createTime', width: 80 },
            { label: '', name: 'updatetime', index: 'updateTime', width: 80 },
            { label: '', name: 'iseff', index: 'iseff', width: 80 }
        ],
		viewrecords: true,
        height: 450,
        rowNum: 100,
		rowList : [100],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: false,
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
    vm.getTermCommList();

});

var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "menuId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    },
    check:{
        enable:true,
        nocheckInherit:true
    }
};
var ztree;

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			key: null
		},
        displayArea:1,
        termCommList:[],
        termClassList:[]

	},
	methods: {
		query: function () {
			vm.reload();
            vm.getTermClassList();
		},
        getTermCommList: function(){
            $.get(baseURL + "user/term/termCommList/1", function(r){
                //alert(termCommList)
                vm.termCommList = r.termCommList;
                console.info(vm.termCommList);
            });
        },
        getTermClassList: function(){
            $.get(baseURL + "user/monthteacher/termClassList/"+vm.q.key, function(r){
                //alert(termCommList)
                vm.termClassList = r.termClassList;
                console.info(vm.termClassList)
            });
        },
        chooseClass: function(){
            vm.displayArea = 2;
            vm.title = "新增";
            vm.role = {};
            vm.getMenuTree(null);
        },
        getMenuTree: function(roleId) {
            //加载菜单树  sys/menu/list
            $.get(baseURL + "user/tclass/classMenuList", function(r){
                ztree = $.fn.zTree.init($("#menuTree"), setting, r);
                //展开所有节点
                ztree.expandAll(true);

                if(roleId != null){
                    vm.getRole(roleId);
                }
            });
        },
		reload: function (event) {
		    vm.displayArea=1;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'key': vm.q.key},
                page:page
            }).trigger("reloadGrid");


		}
	}
});