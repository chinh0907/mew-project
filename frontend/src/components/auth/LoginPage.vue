<template>
  <div class="container">
    <div class="logo">
      <h1>MEW에 놀러온걸 환영해요!</h1>
    </div>

    <!-- 기본 submit 막고 login 메서드 호출 -->
    <form @submit.prevent="login">
      <input v-model="form.id" type="text" placeholder="아이디" required />
      <input v-model="form.pw" type="password" placeholder="비밀번호" required />

      <div>
        <div>비밀번호를 잊으셨나요?</div>

        <button class="login-btn" type="submit">로그인</button>

        <div>
          계정이 필요하신가요?
          <RouterLink to="/mew/signup">가입하기</RouterLink>
          <!-- RouterView는 상위 레이아웃에서 쓰는 편이 좋으므로 제거 -->
        </div>
      </div>
    </form>
  </div>
</template>

<script>
/* ---------- 필요한 라이브러리 import ---------- */
import axios from "axios";
import { useRouter } from "vue-router";

export default {
  name: "LoginPage",

  /* ---------- data() ---------- */
  data() {
    return {
      // v-model로 연결할 폼 상태
      form: {
        id: "",
        pw: "",
      },
    };
  },

  /* ---------- created / mounted 등 라이프사이클에서 router 사용을 위해 ---------- */
  setup() {
    // Options API에서도 setup()을 병행해 컴포지션 훅 사용 가능
    const router = useRouter();
    return { router };
  },

  /* ---------- methods ---------- */
  methods: {
    async login() {
      try {
        // JSON 바디 전송: qs, Content-Type 수동 설정 불필요
        await axios.post("http://localhost:8080/api/auth/login", {
          username: this.form.id,
          password: this.form.pw,
        });

        // setup()에서 반환한 router는 this.router로 접근
        this.router.push("/dashboard");
      } catch (e) {
        alert("로그인 실패");
        console.error(e);
      }
    },
  },
};
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

input[type="text"],
input[type="password"] {
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