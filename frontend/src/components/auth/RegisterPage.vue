<template>
  <div class="container">
    <div class="logo">
      <h1>계정 만들기</h1>
    </div>

    <form>
      <input type="text" placeholder="이메일" required />
      <input type="text" placeholder="사용자명" required />
      <input type="password" placeholder="비밀번호" required />
      <input type="password" placeholder="비밀번호 확인" required />
      <div class="birth-selects">
        <select v-model="selectedYear">
          <option disabled value="" selected>년 선택</option>
          <option v-for="year in years" :key="year" :value="year">
            {{ year }}년
          </option>
        </select>

        <select v-model="selectedMonth">
          <option disabled value="" selected>월 선택</option>
          <option v-for="month in months" :key="month" :value="month">
            {{ month }}월
          </option>
        </select>

        <select v-model="selectedDay">
          <option disabled value="" selected>일 선택</option>
          <option v-for="day in daysInMonth" :key="day" :value="day">
            {{ day }}일
          </option>
        </select>
      </div>

      <button class="regi-btn">가입하기</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "RegisterPage",
  data() {
    return {
      selectedYear: '',
      selectedMonth: '',
      selectedDay: '',
      years: [], // 여기선 빈 배열로 두기
      months: Array.from({ length: 12 }, (_, i) => i + 1),
      message: "Click the button to fetch message",
    };
  },
  created() {
    this.years = this.generateYears(); // 이곳에서 메서드 호출
  },
  methods: {
    generateYears() {
      const currentYear = new Date().getFullYear();
      return Array.from({ length: 100 }, (_, i) => currentYear - i);
    },
    async fetchMessage() {
      try {
        const response = await fetch("http://localhost:8080/api/hello");
        const text = await response.text();
        this.message = text;
      } catch (error) {
        console.error("Error fetching message:", error);
        this.message = "Failed to fetch message";
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
  width: 100%;
  font-size: 24px;
  font-weight: bold;
  text-align: center;
}

input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 14px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 14px;
}
.regi-btn {
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

select {
  width: 10%;
  padding: 12px;
  margin: 8px 0;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  background-color: white;
  appearance: none; /* 화살표 제거 (원하는 스타일로 커스터마이징 가능) */
}

.birth-selects {
  display: flex;
  gap: 10px;
  width: 100%;
}

.birth-selects select {
  flex: 1;
  padding: 12px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
}
</style>