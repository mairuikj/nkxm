/**
 * Created by asus on 2019/5/5.
 */
(function (doc, win) {
    var docEl = doc.documentElement;
        resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
        recalc = function () {
            var clientWidth = docEl.clientWidth;
            if (!clientWidth) return;
            docEl.style.fontSize = 20 * (clientWidth / 750) + 'px';

        };

    if (!doc.addEventListener) return;
    win.addEventListener(resizeEvt, recalc, false);
    doc.addEventListener('DOMContentLoaded', recalc, false);
})(document, window);

function request(url,data,fn){
    var baseUrl = ''
    url = baseUrl + url
    $.ajax({
        url  : url,
        type: 'post',
        async: true,
        dataType : "json",
        data : data,
        success: function(response){
            if(response.code == "0"){
                //请求成功后执行
                fn(response.data)
            }else{
                //请求失败
                alert("请求数据失败！")
            }
        },
        error:function (err) {
            alert('请求出错！')
            console.log('请求出错:',err)
        }
    });
}