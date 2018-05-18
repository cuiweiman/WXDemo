var app=getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
      resident:null,
      faultList:null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    that.setData({
      resident: app.appData.userInfo
    })
    var id=that.data.resident.id;

    wx.request({
      url: 'https://www.cuiweiman.xyz/WXDemo/fault/findFaultList.action',
      data: {
        rid: id
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded' // post
      },
      method: 'POST',
      success: function(res) {
        if(1 == res.data.status){
          that.setData({
            faultList: res.data.message
          })
        }
      }
    })






  },





  toDetail:function(e){
    var fid=e.currentTarget.id;
    wx.navigateTo({
      url: '../detail/detail?id='+fid
    })
  }


})