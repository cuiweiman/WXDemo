
var app=getApp();

function countdown(that) {
  that.setData({
    btnStatus:true
  })
  var second = that.data.second
  if (second == 0) {    // console.log("Time Out...");
    that.setData({
      second: 60,
      btnStatus:false
    }); return;
  }
  var time = setTimeout(function () {
    that.setData({
      second: second - 1
    });
    countdown(that);
  }
    , 1000)
}

Page({

  /**
   * 页面的初始数据
   */
  data: {
    phone:'',
    identify:'',
    password:'',
    password2:'',
    verifyCode:'',
    subBtnstatus:true,
    second:60,
    btnStatus:false
  },


  phoneInput:function(e){
    this.setData({
      phone:e.detail.value
    })
  },
  identifyInput:function(e){
    this.setData({
      identify:e.detail.value
    })
  },
  passwordInput:function(e){
    this.setData({
      password:e.detail.value
    })
  },
  password2Input:function(e){
    this.setData({
      password2:e.detail.value
    })
  },

  getIdentifyCode:function(){
    var that=this
    if(this.data.phone==''){
      wx.showToast({
        title: '手机号为空',
        icon: 'loading',
        duration: 1000
      })
    }else if(this.data.phone.length!=11){
      wx.showToast({
        title: '号码错误',
        icon: 'loading',
        duration: 1000
      })
    }
    else{
      countdown(this)
      wx.request({
        url: 'https://www.cuiweiman.xyz/WXDemo/resident/getVerifyingCode.action',
        data: {
          tel:that.data.phone
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        method: 'POST',
        success: function(res) {
          if(1==res.data.status){
            that.setData({
              verifyCode: res.data.message
            })
          }
        }
      })
    }
    
  },
  
  checkIdentify:function(){
    var that=this
    console.log(that.data.verifyCode)
    console.log(that.data.identify)

    if(that.data.identify==''){
      wx.showToast({
        title: '请输入验证码',
        icon: 'loading',
        duration: 1000
      })
    }

    if (that.data.verifyCode != that.data.identify) {
      wx.showToast({
        title: '验证码输入错误',
        icon: 'loading',
        duration: 1000
      })
    }

  },

  checkPass:function(){
    if(this.data.password==''){
      wx.showToast({
        title: '密码不能为空',
        icon: 'loading',
        duration: 1000
      })
    }
  },

  checkPass2:function(){
    var that=this
    if(this.data.password2!=this.data.password){
      wx.showToast({
        title: '密码不一致',
        icon: 'loading',
        duration: 1000
      })
    } else if (that.data.phone != '' && that.data.password != '' && that.data.identify != '' && that.data.identify==that.data.verifyCode){
      that.setData({
        subBtnstatus:false
      })
  }

  },
  
  resetPassword:function(){
     var that=this;
     wx.request({
       url: 'https://www.cuiweiman.xyz/WXDemo/resident/updatePass.action',
       data: {
            tel: that.data.phone,
            password:that.data.password
       },
       header: {
         'content-type': 'application/x-www-form-urlencoded'
       },
       method: 'POST',
       success: function(res) {
         if (1 == res.data.status){
           wx.redirectTo({
             url: '../login/login',
           })
         }else{
           wx.showToast({
             title: '改密失败',
             icon: 'loading',
             duration: 1000
           })
         }
       }
     })


  }

  



})