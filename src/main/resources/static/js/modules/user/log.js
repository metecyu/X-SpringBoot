$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/monthteacher/list',
        datatype: "json",
        colModel: [
            { label: 'monthteacherid', name: 'monthteacherid', index: 'monthteacherid', width: 50, key: true },
            { label: '期数编号', name: 'termid', index: 'termid', width: 80 },
            { label: '11', name: 'teacherid', index: 'teacherId', width: 80 },
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
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			key: null
		},
	},
	methods: {
		query: function () {
			vm.reload();
		},
		reload: function (event) {
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'key': vm.q.key},
                page:page
            }).trigger("reloadGrid");
		}
	}
});