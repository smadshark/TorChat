var app = new Vue({
    //바인딩 마크업
    el: "#app",

    //변수
    data: {
        message: "P0r1o2j3e4c5t6"
    },

    //필터
    filters: {
       excludeNum : function(value) {
          if(!value){
            return "";
          }
          value = value.toString();
          return value.replace(/[0-9]/g,"");
        }
    }
});

var router = new VueRouter({
  mode: "history" /*Vue 라우터는 기본적으로 '루트 URL'/#/'라우터 이름'의 구조로 되어 있다. #값을 제외하고싶은 모드 */
});

// 컴포넌트 등록 코드
Vue.component('my-component', {
  // 컴포넌트 내용
  template: '<div>A custom component!</div>',

})