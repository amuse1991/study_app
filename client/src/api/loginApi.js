const axios = require('axios')

export const getAuthToken = (uid,pwd)=>{
    axios.post(`/users/auth`,{
        id:uid,
        pwd:pwd
    }).then(()=>{
        console.log("로그인 성공, 인증 토큰 발행")
    }).catch(()=>{
        console.log("로그인 실패")
    })
}