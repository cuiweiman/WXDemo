var app=getApp();


Page({

  /**
   * 页面的初始数据
   */
  data: {
      noticeList:null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    var that=this
    // 加载社区通知
    wx.request({
      url: 'https://www.cuiweiman.xyz/WXDemo/notice/getNoticeList.action',
      data: {
        cid: 171115120856
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded' // post
      },
      method: 'POST',
      success: function (res) {
        that.setData({
          noticeList: res.data.message
        })
      }
    })
  },



  toDetail:function(e){
    var nid = e.currentTarget.id;
    wx.navigateTo({
      url: 'noticearticle/noticearticle?id='+nid
    })
  }



















})