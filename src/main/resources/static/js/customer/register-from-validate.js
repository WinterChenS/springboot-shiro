$.validator.setDefaults({
    highlight: function (element) {
        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function (element) {
        element.closest('.form-group').removeClass('has-error').addClass('has-success');
    },
    errorElement: "span",
    errorPlacement: function (error, element) {
        if (element.is(":radio") || element.is(":checkbox")) {
            error.appendTo(element.parent().parent().parent());
        } else {
            error.appendTo(element.parent());
        }
    },
    errorClass: "help-block m-b-none",
    validClass: "help-block m-b-none"


});


//以下为官方示例
$().ready(function () {


    // validate signup form on keyup and submit
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#registerFrom").validate({
        rules: {
            userName: {
                required: true,
                minlength: 2
            },
            password: {
                required: true,
                minlength: 5
            },
            confirm_password: {
                required: true,
                minlength: 5,
                equalTo: "#password"
            },
            agree: "required"

        },
        messages: {

            userName: {
                required: icon + "请输入您的用户名",
                minlength: icon + "用户名必须两个字符以上"
            },
            password: {
                required: icon + "请输入您的密码",
                minlength: icon + "密码必须5个字符以上"
            },
            confirm_password: {
                required: icon + "请再次输入密码",
                minlength: icon + "密码必须5个字符以上",
                equalTo: icon + "两次输入的密码不一致"
            },
            agree: {
                required: icon + "必须同意协议后才能注册",
                element: '#agree-error'
            }
        }
    });

});