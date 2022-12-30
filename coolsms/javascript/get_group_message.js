const { config, Group } = require('coolsms-node-sdk')
const conf = require('../config')

/*
 coolsms js example
 get group messages
*/

config.init({
  apiKey: conf.apiKey,
  apiSecret: conf.apiSecret
})
getGroupMessages({
  text: `${conf.text} from Javascript`,
  type: conf.type,
  to: conf.to,
  from: conf.from
})
async function getGroupMessages (message) {
  try {
    const group = new Group()
    await group.createGroup()
    await group.addGroupMessage(message)
    console.log(await group.getMessageList())
  } catch (e) {
    console.log(e)
  }
}
