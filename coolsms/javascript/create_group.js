const { config, Group } = require('coolsms-node-sdk')
const conf = require('../config')

/*
 coolsms js example
 send group messages
*/

config.init({
  apiKey: conf.apiKey,
  apiSecret: conf.apiSecret
})
createGroup({
  text: `${conf.text} from Javascript`,
  type: conf.type,
  to: conf.to,
  from: conf.from
})
async function createGroup (message) {
  try {
    const group = new Group()
    await group.createGroup()
    const groupId = group.getGroupId()
    console.log('groupId: ', groupId)
  } catch (e) {
    console.log(e)
  }
}
