let vue = new Vue({
    el: '#app',
    data: {
		leftIndex: 0,
        msg:'',
        //用户信息
        userInfo: {},
        userOldPwd:'',
        userNewPwd:'',
		//网店
		onlineStore:{
			list:[
                {"id":"","url":"","createDate":"","updateDate":null,"type":1,"tableIndex":0,"":"","shopkeeper":null}
			],
			os: {id:'',url:'',type:1,createDate:''},
			type:0
		},
		// 订单
        cart: [{
            brand: {
                id: "123",
                name: "youjie"
            },
            products: [{
                pid: "456",
                pimg: 'https://img.alicdn.com/bao/uploaded/i2/36054738/TB2e1_nXWAoBKNjSZSyXXaHAVXa_!!36054738.jpg_80x80.jpg',
                pname: 'Intel/英特尔 i7 8700K 酷睿六核CPU中文盒装Z370主板吃鸡套装',
                pmoney: 99999,
                pnumber: 11234
            },{
                pid: "456",
                pimg: 'https://img.alicdn.com/bao/uploaded/i2/36054738/TB2e1_nXWAoBKNjSZSyXXaHAVXa_!!36054738.jpg_80x80.jpg',
                pname: 'Intel/英特尔 i7 8700K 酷睿六核CPU中文盒装Z370主板吃鸡套装',
                pmoney: 99999,
                pnumber: 11234
            }]
        }]
    },
	mounted(){

		var theme = "ios";
        var mode = "scroller";
        var display = "bottom";
        var lang="zh";
		let date = this.$refs.date
        console.log('date:::::::::::::'+date)
		$(date).mobiscroll().date({
            theme: theme,
            mode: mode,
            display: display,
            lang: lang
        });
        //初始化
        onlineStoreGet()
        userInfoGet()

	},
    methods: {
        tapleftIndex(index) {
            this.leftIndex = index;
        },
		// 预览网店
		onlineStorePre(index,type){
            this.msg= ''
        	if(type==1){ //申请
                this.onlineStore.type=0
                this.onlineStore.os={id:'',url:'',type:1,createDate:''}
                return;
			}
            this.onlineStore.os.id =this.onlineStore.list[index].id
            this.onlineStore.os.url =this.onlineStore.list[index].url
            this.onlineStore.os.type =this.onlineStore.list[index].type
            this.onlineStore.type=1
		},
		// 申请网店
		onlineStorereg(){
            let _this = this;
            var params = new URLSearchParams();
			params.append('url', _this.onlineStore.os.url);
			params.append('type', _this.onlineStore.os.type);
			axios.post('http://localhost/apply/shopkeeper/onlineStorereg', params)
			.then(function (response) {
				let onlineStore = _this.$refs.onlineStore;
				if(response.data.status==1) {
                    _this.onlineStore.os={id:'',url:'',type:1,createDate:''}
                    onlineStoreGet()
					setTimeout(()=>{
                        $(onlineStore).modal('hide')
                        _this.msg='';
					},1000)
				}else {

				}
                _this.msg = response.data.msg;
				console.log(response);
			})
			.catch(function (error) {
				console.log(error);
			});
		},
		//网店修改
		chageOnlineStore(){
			let _this = this;
			var params = new URLSearchParams();
			params.append('url', _this.onlineStore.os.url);
			params.append('type', _this.onlineStore.os.type);
			params.append('id', _this.onlineStore.os.id)
			axios.post('http://localhost/apply/shopkeeper/onlineStoreChange', params)
			.then(function (response) {
                if(response.data.status==1) {
                    _this.onlineStore.os={id:'',url:'',type:1,createDate:''}
                    onlineStoreGet()
                    setTimeout(()=>{
                        $(onlineStore).modal('hide')
                        _this.msg='';
                    },1000)
                }else {

                }
                _this.msg = response.data.msg;
				console.log(response);
			})
			.catch(function (error) {
				console.log(error);
			});
		},
        onlineStoreDel(id) {
            axios.get('http://localhost/apply/shopkeeper/onlineStoreDel',{
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
            axios.post('http://localhost/apply/shopkeeper/userUpdate', params)
                .then(function (response) {
                    if(response.data.status==1) {
                        _this.msg = '用户信息更新成功'
                        _this.userOldPwd=''
                        _this.userNewPwd=''
                    }else {
                        _this.msg = '用户信息更新失败，密码不正确！'
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})

function onlineStoreGet(){
    axios.get('http://localhost/apply/shopkeeper/onlineStore')
        .then(function (response) {
            vue.onlineStore.list = response.data;
        })
        .catch(function (error) {
            console.log(error);
        });
}

function userInfoGet(){
    axios.get('http://localhost/apply/shopkeeper/userInfo')
        .then(function (response) {
            vue.userInfo = response.data;
        })
        .catch(function (error) {
            console.log(error);
        });
}
