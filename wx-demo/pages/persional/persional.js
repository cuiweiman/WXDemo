
var app=getApp();

Page({


  /**
   * 页面的初始数据
   */
  data: {
      resident: null
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      resident:app.appData.userInfo
    })
  },



  toAboutus:function(){
    wx.navigateTo({
      url: '../aboutus/aboutus',
    })
  },

  toPassword:function(){
    wx.navigateTo({
      url: '../password/password',
    })
  },



  logout:function(){
    app.appData.userInfo = null;
    app.appData.communityInfo=null;
    wx.redirectTo({
      url: '../login/login',
    })
  }




})