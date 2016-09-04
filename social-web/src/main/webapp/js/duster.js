var Duster = function(){

	return {
		buildArr:function(tmplEle){
			var buildingTemplate = dust.compile(tmplEle.html(),"_dust_"+tmplEle.id);
      dust.loadSource(buildingTemplate);
      return function(building) { 
          var result;   
          dust.render("_dust_"+tmplEle.id, {"data":building}, function(err, res) {
            result = res;
        });   
        return result;
      };
		},

    getParam:function getQueryParams() {
      var params={}
      if (location.search) {
          var parts = location.search.substring(1).split('&');
          for (var i = 0; i < parts.length; i++) {
              var nv = parts[i].split('=');
              if (!nv[0]) continue;
              params[nv[0]] = nv[1] || true;
          }
      }
      return params;

    }

	};//return

}();