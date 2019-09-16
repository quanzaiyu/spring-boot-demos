const fs = require('fs')
const { execSync } = require('child_process')
let readline = require('readline')
let version = require('../package').version

let oldVersion = version.trim()
let parts = version.trim().split('.')
parts[2] = parseInt(parts[2]) + 1
let newVersion = parts.join('.');

let replaceFile = ['../package.json']

replaceFile.forEach(file => {
  let data = fs.readFileSync(__dirname + '/' + file, {
    encoding: 'utf-8'
  })
  let reg = new RegExp(oldVersion, "g");
  let result = data.replace(reg, newVersion);
  fs.writeFileSync(__dirname + '/' + file, result, {
    encoding: 'utf-8'
  })
  console.log(file + ': 替换成功');
})

// 创建readline接口实例
let rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question("请输入git commit: ", (answer) => {
  let icons = ['🍻', '🍺', '💗', '✨', '📝', '🎨'];
  console.log(execSync('git add .', { encoding: 'utf-8'}))
  console.log(execSync(`git commit -am ${icons[parseInt(Math.random()*10 % icons.length)] + answer}`, { encoding: 'utf-8'}))
  console.log(execSync('git push origin master', { encoding: 'utf-8'}))
  rl.close();
})
