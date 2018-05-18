var app=getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
      community:null
  },

  onLoad:function(){
      this.setData({
        community:app.appData.communityInfo
      })
    
  },

  call:function(){
    wx:wx.makePhoneCall({
      phoneNumber: this.data.community.phone,
      success: function(res) {},
      fail: function(res) {},
      complete: function(res) {},
    })
  }

})