const { config, Group } = require('coolsms-node-sdk')
const conf = require('../config')

/*
 coolsms js example
 delete group
*/

config.init({
  apiKey: conf.apiKey,
  apiSecret: conf.apiSecret
})
deleteGroup()
async function deleteGroup () {
  try {
    const group = new Group()
    await group.createGroup()
    const groupId = group.getGroupId()
    console.log(await Group.deleteGroup(groupId))
  } catch (e) {
    console.log(e)
  }
}
