const { config, Group, Image } = require('coolsms-node-sdk')
const conf = require('../config')
const fs = require('fs')

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

// 이미지 생성
async function createImage() {
  // 이미지 파일 읽어오기
  const rawImage = fs.readFileSync('testImage.jpg')
  // 파일을 base64 로 변환
  const base64Image = rawImage.toString('base64')
  const ImageCreator = new Image(base64Image)
  return await ImageCreator.createImage()
}

// 문자 발송
async function send(message) {
  try {
    const imageId = await createImage()
    const body = {
      ...message,
      imageId,
      type: 'MMS',
      subject: 'javascript image test'
    }
    const group = new Group()
    await group.createGroup()
    await group.addGroupMessage(body)
    console.log(await group.sendMessages())
  } catch (e) {
    console.log(e)
  }
}
