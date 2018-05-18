
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


  nextBt:function(){
    wx.navigateTo({
      url: '../payment/payment'
    })
  }


})