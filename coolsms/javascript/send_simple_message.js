const { config, Group } = require('coolsms-node-sdk')
const conf = require('../config')

/*
 coolsms js example
 send simple messages
*/

config.init({
  apiKey: conf.apiKey,
  apiSecret: conf.apiSecret
})
send({
  text: `${conf.text} from JavaScript`,
  type: conf.type,
  to: conf.to,
  from: conf.from
})



async function send (message, agent = {}) {
  try {
    console.log(await Group.sendSimpleMessage(message, agent))
  } catch (e) {
    console.log(e)
  }
}
