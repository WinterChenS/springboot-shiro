/**
 * Created by Alone on 2017/11/6.
 */
var box=document.getElementById('verify_box');
var xbox=document.getElementById('verify_xbox');
var element=document.getElementById('btn');
var b=box.offsetWidth;
var o=element.offsetWidth;
element.ondragstart = function() {
    return false;
};
element.onselectstart = function() {
    return false;
};
element.onmousedown = function(e) {
    var disX = e.clientX - element.offsetLeft;
    document.onmousemove = function (e) {
        var l = e.clientX - disX +o;
        if(l<o){
            l=o
        }
        if(l>b){
            l=b
        }
        xbox.style.width = l + 'px';
    };
    document.onmouseup = function (e){
        var l = e.clientX - disX +o;
        if(l<b){
            l=o
        }else{
            l=b;
            xbox.innerHTML='验证通过<div id="btn"><img  src="/img/customer/kkkk.png"/></div>';
            $('#submit').attr("disabled",false);
        }
        xbox.style.width = l + 'px';
        document.onmousemove = null;
        document.onmouseup = null;
    };
}