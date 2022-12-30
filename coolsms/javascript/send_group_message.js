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
send({
  text: `${conf.text} from Javascript`,
  type: conf.type,
  to: conf.to,
  from: conf.from
})
async function send (message) {
  try {
    const group = new Group()
    await group.createGroup()
    await group.addGroupMessage(message)
    console.log(await group.sendMessages())
  } catch (e) {
    console.log(e)
  }
}
