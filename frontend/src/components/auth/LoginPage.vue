<template>

    <div class="container">
        <div class="logo">
            <h1>MEW에 놀러온걸 환영해요!</h1>
        </div> 

        <form>

            <input type="text" placeholder="아이디" required>
            <input type="password" placeholder="비밀번호" required>

            <div>
            

                <div>비밀번호를 잊으셨나요?</div>

                <button class="login-btn">로그인</button>

                <div>
                    계정이 필요하신가요? 
                    <RouterLink to="/mew/register">가입하기</RouterLink>
                    <RouterView/>
                </div>
            
            
            </div>

        </form>
    </div>

</template>

<script>
export default {
  name: 'LoginPage'
}
</script>

<style>

.container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.logo h1 {
    width: 150%;
    font-size: 24px;
    font-weight: bold;
    text-align: center;
}

input[type="text"], input[type="password"] {
    width: 150%;
    padding: 14px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
}

.login-btn {
    width: 100%;
    background-color: #800080;
    color: white;
    padding: 14px;
    border: none;
    border-radius: 4px;
    font-size: 16px;
    margin-top: 15px;
    cursor: pointer;
}

</style>