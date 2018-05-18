var app = getApp();
Page({
  data: {
    phone: '',
    password: ''
  },

  // 获取输入账号  
  phoneInput: function (e) {
    this.setData({
      phone: e.detail.value
    })
  },

  // 获取输入密码  
  passwordInput: function (e) {
    this.setData({
      password: e.detail.value
    })
  },

  // 登录  
  login: function () {
    if (this.data.phone.length == 0 || this.data.password.length == 0) {
      wx.showToast({
        title: '登录信息不完整',
        icon: 'loading',
        duration: 1000
      })
    } else {
      wx:wx.request({
        url: 'https://www.cuiweiman.xyz/WXDemo/resident/login.action',
        data: {
          tel: this.data.phone,
          password: this.data.password
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded' // post
        },
        method: 'POST',
        success: function(res) {
            if(1==res.data.status){
              app.appData.userInfo =res.data.message;
              wx.showToast({
                title: '登陆成功',
                icon: 'success',
                duration: 10000
              }),
              wx.switchTab({
                url: '../index/index',
              })
            }else{
              wx.showToast({
                title: '登录信息有误',
                icon: 'loading',
                duration: 1000
              })
            }
        },
        fail: function(res) {
          wx.showToast({
            title: '登录失败',
            icon: 'loading',
            duration: 1000
          })
        }
      })

      

    }
  },

  register: function () {
    wx.navigateTo({
      url: '../register/register'
    })
  },


  forgetPassword: function () {
    wx.navigateTo({
      url: '../password/password',
    })
  }





})  
