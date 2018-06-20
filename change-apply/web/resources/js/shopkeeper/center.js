let vue = new Vue({
    el: '#app',
    data: {
        leftIndex: 0,
        msg: '',
        //用户信息
        userInfo: {},
        //支付宝
        aliPay: {account: '', aliPay: '', czMoney: '', txMoney: ''},
        isaliPay: 1,
        userOrder: null,
        userOldPwd: '',
        userNewPwd: '',
        //网店
        onlineStore: {
            list: [
                {
                    "id": "",
                    "url": "",
                    "createDate": "",
                    "updateDate": null,
                    "type": 1,
                    "tableIndex": 0,
                    "": "",
                    "shopkeeper": null
                }
            ],
            os: {id: '', url: '', type: 1, createDate: ''},
            type: 0
        },
        //订单状态
        orderStatus:0,
    },
    mounted() {
        let url = window.location.href
        this.leftIndex = url.charAt(url.length - 1) >= 0 && url.charAt(url.length - 1) <= 9 ? url.charAt(url.length - 1) : 0;
        //初始化
        onlineStoreGet()
        userInfoGet()
        userOrder()
    },
    methods: {
        tapleftIndex(index) {
            this.leftIndex = index;
            if (index == 2) {
                var theme = "ios";
                var mode = "scroller";
                var display = "bottom";
                var lang = "zh";
                let date = this.$refs.date;
                // console.log(date)
                // $('#demo_datetime').mobiscroll().date({
                //     theme: theme,
                //     mode: mode,
                //     display: display,
                //     lang: lang
                // });

                new Mdate(date, { //"dateShowBtn"为你点击触发Mdate的id，必填项
                    acceptId: "dateSelectorTwo", //此项为你要显示选择后的日期的input，不填写默认为上一行的"dateShowBtn"
                    beginYear: "2000",//此项为Mdate的初始年份，不填写默认为2000
                    beginMonth: "1",//此项为Mdate的初始月份，不填写默认为1
                    beginDay: "1",//此项为Mdate的初始日期，不填写默认为1
                    endYear: "2020",//此项为Mdate的结束年份，不填写默认为当年
                    endMonth: "1",//此项为Mdate的结束月份，不填写默认为当月
                    endDay: "1",//此项为Mdate的结束日期，不填写默认为当天
                    format: "-"//此项为Mdate需要显示的格式，可填写"/"或"-"或".",不填写默认为年月日
                })
            }
        },
        // 预览网店
        onlineStorePre(index, type) {
            this.msg = ''
            if (type == 1) { //申请
                this.onlineStore.type = 0
                this.onlineStore.os = {id: '', url: '', type: 1, createDate: ''}
                return;
            }
            this.onlineStore.os.id = this.onlineStore.list[index].id
            this.onlineStore.os.url = this.onlineStore.list[index].url
            this.onlineStore.os.type = this.onlineStore.list[index].type
            this.onlineStore.type = 1
        },
        // 申请网店
        onlineStorereg() {
            let _this = this;
            var params = new URLSearchParams();
            params.append('url', _this.onlineStore.os.url);
            params.append('type', _this.onlineStore.os.type);
            axios.post('http://localhost:8080/shopkeeper/onlineStorereg', params)
                .then(function (response) {
                    let onlineStore = _this.$refs.onlineStore;
                    if (response.data.status == 1) {
                        _this.onlineStore.os = {id: '', url: '', type: 1, createDate: ''}
                        onlineStoreGet()
                        setTimeout(() => {
                            $(onlineStore).modal('hide')
                            _this.msg = '';
                        },1000)

                    } else {

                    }
                    _this.msg = response.data.msg;
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        //网店修改
        chageOnlineStore() {
            let _this = this;
            var params = new URLSearchParams();
            params.append('url', _this.onlineStore.os.url);
            params.append('type', _this.onlineStore.os.type);
            params.append('id', _this.onlineStore.os.id)
            axios.post('http://localhost:8080/shopkeeper/onlineStoreChange', params)
                .then(function (response) {
                    if (response.data.status == 1) {
                        _this.onlineStore.os = {id: '', url: '', type: 1, createDate: ''}
                        onlineStoreGet()
                        setTimeout(() => {
                            $(onlineStore).modal('hide')
                            _this.msg = '';
                        },1000)
                    } else {

                    }
                    _this.msg = response.data.msg;
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        onlineStoreDel(id) {
            axios.get('http://localhost:8080/shopkeeper/onlineStoreDel', {
                params: {
                    id: id
                }
            })
                .then(function (response) {
                    console.log(response)
                    onlineStoreGet()
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        userUpdate() {
            let _this = this;
            var params = new URLSearchParams();
            params.append('phone', _this.userInfo.user.phone);
            params.append('email', _this.userInfo.user.email);
            params.append('password', _this.userOldPwd)
            params.append('newPwd', _this.userNewPwd)
            axios.post('http://localhost:8080/shopkeeper/userUpdate', params)
                .then(function (response) {
                    if (response.data.status == 1) {
                        _this.msg = '用户信息更新成功'
                        _this.userOldPwd = ''
                        _this.userNewPwd = ''
                    } else {
                        _this.msg = '用户信息更新失败，密码不正确！'
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        aliPayChange(index) {
            this.isaliPay = index;
            console.log(this.isaliPay)
            if (this.userInfo != null && this.userInfo.aliPay != null) {
                this.aliPay.account = this.userInfo.aliPay.account
                this.aliPay.realName = this.userInfo.aliPay.realName
            }
        },
        //充值到本系统
        Recharge() {
            //获取用户输入总金额
            var totalAmount = this.aliPay.czMoney;
            var number = Number(totalAmount);
            if (isNaN(number)) {
                $("#tishi1").html("请输入正确金额数！");
                return false;
            }
            $("#tishi").html("");
            //备注
            var remark = "充值" + totalAmount + "元";
            //标题
            var title = "充值";

            //填充表单内容
            $("#form-callbackUrl").attr("value","http://localhost:8080/shopkeeper/rechargeCallBack");
            $("#form-totalAmount").attr("value",number);
            $("#form-title").attr("value",title);
            $("#form-content").attr("value",remark);
            // alert($("#form-callbackUrl").attr("value")+"-"+$("#form-totalAmount").attr("value")+"-"+$("#form-title").attr("value")+"-"+$("#form-content").attr("value"));
            //提交充值表单
            $("#formid").submit();
        },
        //提现到用户支付宝
        withdraw() {
            //获取用户输入总金额
            var totalAmount = this.aliPay.txMoney;
            var number = Number(totalAmount);
            if (isNaN(number)) {
                $("#tishi2").html("请输入正确金额数！");
                return false;
            }
            var money = $("#span").text();
            money = Number(money);
            if(totalAmount > money){
                $("#tishi2").html("取少点~");
                return false;
            }
            $("#tishi").html("");

            //获取用户支付宝账户
            // var payeeAccount = this.aliPay.account;
            var payeeAccount = "pbduln3011@sandbox.com";
            //获取用户名
            // var payeeRealName = this.aliPay.realName;
            var payeeRealName = "沙箱环境";
            //支付展示名
            var shouName = payeeRealName;

            var transParam = {
                payeeRealName: payeeRealName,
                amount: number,
                remark: "提现" + number + "元",
                payerShowName:shouName,
                payeeAccount: payeeAccount
            };
            //异步转账
            $.ajax({
                url: "http://localhost:8080/trans/withdraw",
                method: "post",
                dataType: "json",
                data: transParam,
                success: function (data) {
                    if (data) {
                        alert("提现成功！请留意支付宝到账通知。");
                        window.location.reload();
                    } else {
                        alert("提现失败！");
                    }
                }
            });
        },
        //根据订单状态查询订单
        orderStatusList(index){
            console.log("status------------------"+index)
            this.orderStatus = index;
            axios.get('http://localhost:8080/shopkeeper/orderList?page=1&pageSize=1000&status='+index)
                .then(function (response) {
                    vue.userOrder = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }

    }
})

function onlineStoreGet() {
    axios.get('http://localhost:8080/shopkeeper/onlineStore')
        .then(function (response) {
            vue.onlineStore.list = response.data;
        })
        .catch(function (error) {
            console.log(error);
        });
}

function userInfoGet() {
    axios.get('http://localhost:8080/shopkeeper/userInfo')
        .then(function (response) {
            vue.userInfo = response.data;
        })
        .catch(function (error) {
            console.log(error);
        });
}

function userOrder() {
    axios.get('http://localhost:8080/shopkeeper/orderList?page=1&pageSize=10')
        .then(function (response) {
            vue.userOrder = response.data;
        })
        .catch(function (error) {
            console.log(error);
        });
}

