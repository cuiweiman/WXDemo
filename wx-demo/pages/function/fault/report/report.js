var app=getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    resident: null,
  },

  onLoad: function (options) {
    var that = this;
    that.setData({
      resident: app.appData.userInfo
    })
  },

  bindFormSubmit: function (e) {
    var that=this
    var farea = e.detail.value.fault_area
    var fthing = e.detail.value.fault_thing
    var fdescripe = e.detail.value.fault_descripe
    var fflag=0
    var frid=that.data.resident.id

    wx.request({
      url: 'https://www.cuiweiman.xyz/WXDemo/fault/addFault.action',
      data: {
          area:farea,
          thing:fthing,
          descripe:fdescripe,
          flag:fflag,
          rid:frid
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded' 
      },
      method: 'POST',
      success: function(res) {
          wx.redirectTo({
            url: '../list/list',
          })
      }
    })
    

  }


})