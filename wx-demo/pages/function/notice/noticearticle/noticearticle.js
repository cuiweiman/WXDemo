// pages/function/notice/noticearticle/noticeargicle.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      notice:null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    var that = this;
    var id = options.id;
    wx.request({
      url: 'https://www.cuiweiman.xyz/WXDemo/notice/getNoticeById.action',
      data: {
        nid: id
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'POST',
      success: function (res) {
        that.setData({
          notice: res.data.message
        })
      }
    })




  },

})