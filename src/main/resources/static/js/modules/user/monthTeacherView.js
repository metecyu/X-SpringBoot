$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/monthteacher/list',
        datatype: "json",
        colModel: [
            { label: '编号', name: 'monthteacherid', index: 'monthteacherid', width: 20, key: true },
/*            { label: '期数编号', name: 'termid', index: 'termid', width: 80 },*/
            { label: '教师', name: 'teachername', index: 'teachername', width: 20 },
            { label: '单价', name: 'unitprice', index: 'unitprice', width: 20 },
            { label: '总课时', name: 'sumhour', index: 'sumhour', width: 20 },
            { label: '课酬100%', name: 'sumprice', index: 'sumprice', width: 20 },
            { label: '课酬实际', name: 'sumfactprice', index: 'sumfactprice', width: 20 },
            { label: '课时', name: 'monthteacherclassEntityList', index: 'monthteacherclassEntityList',
                formatter: function(value, options, row){
                    // alert(value)
                    console.info(value)
                    var strAll='';
                    for(var i=0,l=value.length;i<l;i++){
                       var str =    value[i].classhour
                       // strAll =strAll+ '<span class="label-success '"\> '+str+'\</span>';
                        var strClass =""
                        strAll =strAll +value[i].classname + '<span class="label label-success ">'+str+'</span> ';
                    }
                    //var userData=$("#"+options.gid).jqGrid('getGridParam','userData');
                    console.info('strAll:'+strAll)
                    return strAll;
                }
            },
            { label: '操作', name: 'monthteacherid', index: 'monthteacherid',width:60}
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
    //vm.q.key=10
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
        thisTermId:null,
        term:{termSignCN:null},
        displayArea:1,
        thisMonthteacherclass:{classhour:12,classid:null}, //添加工时时使用
        termCommList:[], //期数下拉框
        termClassList:[]

	},
	methods: {
		query: function () {
			vm.reload();
            vm.getTermClassList();
		},
        getTermCommList: function(){ //期数下拉框
            $.get(baseURL + "user/term/termCommList/1", function(r){
                //alert(termCommList)
                vm.termCommList = r.termCommList;
                console.info(vm.termCommList);
            });
        },
        getTermClassList: function(){  // 本期班级列表
            $.get(baseURL + "user/monthteacher/termClassList/"+vm.q.key, function(r){
                //alert(termCommList)
                vm.termClassList = r.termClassList;
                console.info(vm.termClassList)
            });
        },
        chooseClass: function(){
            vm.displayArea = 2;
            vm.title = "添加班级";
            vm.role = {};
            vm.getMenuTree( vm.thisTermId );
        },
        toAddClassHour: function(){
            vm.displayArea = 3;
            vm.title = "添加工时";
            vm.role = {};
            vm.getMenuTree( vm.thisTermId );
        },
        getMenuTree: function(termid) {
		    //alert('getMenuTree:'+termid )
            //加载菜单树  sys/menu/list
            $.get(baseURL + "user/tclass/classMenuList", function(r){
                ztree = $.fn.zTree.init($("#menuTree"), setting, r);
                //展开所有节点
                ztree.expandAll(true);
                //alert(222233)
                vm.getThisTermInfo(termid);
            });
        },
        saveOrUpdateClass: function () { //保存本期班级
		    //alert(1)
            if(vm.validator()){
                return ;
            }
            //alert(2)
            //获取选择的菜单
            var nodes = ztree.getCheckedNodes(true);
            var menuIdList = new Array();
            for(var i=0; i<nodes.length; i++) {
                menuIdList.push(nodes[i].menuId);
            }
            vm.term.thisTermClassIdList = menuIdList;
            // alert(1)
            var url = vm.term == null ? "user/monthteacher/updateThisTermClassIdList" : "user/monthteacher/updateThisTermClassIdList";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.term),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(){
                            vm.reload();
                            vm.getTermClassList();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        getThisTermInfo: function(termId){
		    //alert(333)
            $.get(baseURL + "user/monthteacher/thisTermInfo/"+termId, function(r){
                vm.term = r.term;
                //勾选角色所拥有的菜单
                var menuIds = vm.term.thisTermClassIdList;
                for(var i=0; i<menuIds.length; i++) {
                    var node = ztree.getNodeByParam("menuId", menuIds[i]);
                    ztree.checkNode(node, true, false);
                }
            });
        },
        validator: function () {
           return false
        },
		reload: function (event) {
		    vm.displayArea=1;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
            vm.thisTermId = vm.q.key
            // alert(vm.thisTermId)
			$("#jqGrid").jqGrid('setGridParam',{
				postData:{'key': vm.q.key},
                page:page
            }).trigger("reloadGrid");


		}
	}
});