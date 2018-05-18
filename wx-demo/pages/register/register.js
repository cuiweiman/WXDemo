
var app = getApp();

function countdown(that) {
  that.setData({
    btnStatus: true
  })
  var second = that.data.second
  if (second == 0) {    // console.log("Time Out...");
    that.setData({
      second: 60,
      btnStatus: false
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
    name: '',
    phone: '',
    identify: '',
    verifyCode:'',
    password: '',
    password2: '',
    address: ['请选择', '请选择', '请选择'],
    province:'',
    city:'',
    county:'',
    customItem: '全部',
    community: '请选择小区',
    communityId:'',
    array: [],
    second:60,
    btnStatus:false,
    subBtnstatus:true
  },

  onLoad:function(){
    var that=this;
    wx.request({
      url: 'https://www.cuiweiman.xyz/WXDemo/community/getCommunityList.action',
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'POST',
      success: function (res) {
        if (1 == res.data.status) {
          that.setData({
            array: res.data.message
          })
        }
      }
    })

  },


  /**
   * 姓名输入框赋值
   */
  nameInput: function (e) {
    this.setData({
      name: e.detail.value
    })
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
  passwordInput: function (e) {
    this.setData({
      password: e.detail.value
    })
  },
  password2Input: function (e) {
    this.setData({
      password2: e.detail.value
    })
  },

  /**
   * 选择所在地省市区三级联动
   */
  bindRegionChange: function (e) {
    var that=this;
    this.setData({
      address: e.detail.value,
      province:e.detail.value[0],
      city:e.detail.value[1],
      county:e.detail.value[2]
    })
  },



  /**
   * 获取手机验证码
   */
  getIdentifyCode: function () {
    var that = this
    if (this.data.phone == '') {
      wx.showToast({
        title: '手机号为空',
        icon: 'loading',
        duration: 1000
      })
    } else if (this.data.phone.length != 11) {
      wx.showToast({
        title: '号码错误',
        icon: 'loading',
        duration: 1000
      })
    }
    else {
      countdown(this)
      wx.request({
        url: 'https://www.cuiweiman.xyz/WXDemo/resident/getVerifyingCode.action',
        data: {
          tel: that.data.phone
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        method: 'POST',
        success: function (res) {
          if (1 == res.data.status) {
            that.setData({
              verifyCode: res.data.message
            })
          }
        }
      })
    }
  },



  //选择社区
  bindPickerChange: function (e) {
    var that = this;
    that.setData({
      community: that.data.array[e.detail.value].name,
      communityId: that.data.array[e.detail.value].id
    })

    if (that.data.name != '' && that.data.phone != '' && that.data.password != '' && that.data.identify != '' && that.data.identify == that.data.verifyCode && that.data.communityId != '') {
      that.setData({
        subBtnstatus: false
      })
    }
    
  },




  //验证码判断
  checkIdentify: function () {
    var that = this
    console.log(that.data.verifyCode)
    console.log(that.data.identify)

    if (that.data.identify == '') {
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


  //密码非空
  passCheck:function(){
      var that=this;
      if(that.data.password==''){
        wx.showToast({
          title: '密码为空',
          icon: 'loading',
          duration: 1000
        })
      }
  },

  passCheck2: function () {
    var that = this;
    if (that.data.password != that.data.password2 ) {
      wx.showToast({
        title: '密码不一致',
        icon: 'loading',
        duration: 1000
      })
    } 
  },



  register:function(){
    var that = this;
    if (that.data.name != '' && that.data.phone != '' && that.data.password != '' && that.data.identify != '' && that.data.identify == that.data.verifyCode && that.data.communityId != '' && that.data.password==that.data.password2){
      wx.request({
        url: 'https://www.cuiweiman.xyz/WXDemo/resident/register.action',
        data: {
          name: that.data.name,
          tel: that.data.phone,
          password: that.data.password,
          province: that.data.province,
          city: that.data.city,
          county: that.data.county,
          cid: that.data.communityId
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        method: 'POST',
        success: function (res) {
          if (res.data.status == 1) {
            wx.redirectTo({
              url: '../login/login',
            })
          }
        },
      })
    }else{
      wx.showToast({
        title: '请重新填写',
        icon: 'loading',
        duration: 1000
      })
    }
    

  }

  


})