let vue = new Vue({
	el: '#app',
	data: {
		leftIndex:0,
		userInfo:{
			aliPay:{
				account: 'youjie2015@126.com'
			},
			user: {
				username:'youjie',
				name:'youjie',
				phone:'1111111',
				email:'1111111@qq.com',
				createDate:'2018-6-11 17:29:35',
			},
			balance:99.9
		},
		//支付宝
        aliPay: {account: '', aliPay: '', czMoney: '', txMoney: ''},
        isaliPay: 1,
        
		userOldPwd:'',
		userNewPwd :'',
		msg: '',
		aliPay:null,
		pindex:0,
		oitem: {
			orderCode:1
		}
	},
	mounted(){
		let url = window.location.href
        this.leftIndex = url.charAt(url.length - 1) >= 0 && url.charAt(url.length - 1) <= 9 ? url.charAt(url.length - 1) : 0;
	},
	methods: {
		userUpdate(){
			
		},
		chageTab(index){
			this.leftIndex = index;
		},
		aliPayChange(val) {
			this.isaliPay = val;
		}
	}
})