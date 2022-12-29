const { config, Group } = require('coolsms-node-sdk')
const conf = require('../config')

/*
 coolsms js example
 get group list
*/

config.init({
  apiKey: conf.apiKey,
  apiSecret: conf.apiSecret
})
getGroupList()
async function getGroupList () {
  try {
    const group = new Group()
    await group.createGroup()
    console.log(await Group.getMyGroupList())
  } catch (e) {
    console.log(e)
  }
}
