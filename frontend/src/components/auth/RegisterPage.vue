<template>

    <div class="logo">
        <h1>계정 만들기</h1>
    </div> 

    <form>

        <input type="text" placeholder="이메일" required>
        <input type="text" placeholder="사용자명" required>
        <input type="password" placeholder="비밀번호" required>
        <input type="password" placeholder="비밀번호 확인" required>
        <div>
            <select v-model="selectedYear">
                <option disabled value="">년 선택</option>
                <option v-for="year in years" :key="year" :value="year">
                    {{ year }}년
                </option>
            </select>

            <select v-model="selectedMonth">
                <option disabled value="">월 선택</option>
                <option v-for="month in months" :key="month" :value="month">
                    {{ month }}월
                </option>
            </select>

            <select v-model="selectedDay">
                <option disabled value="">일 선택</option>
                <option v-for="day in daysInMonth" :key="day" :value="day">
                    {{ day }}일
                </option>
            </select>
        </div>

        <button class="regi-btn">가입하기</button>

    </form>

</template>

<script>

export default {
  name: 'RegisterPage',
  data() {
    return {
      message: 'Click the button to fetch message'
    }
  },
  methods: {
    async fetchMessage() {
      try {
        const response = await fetch('http://localhost:8080/api/hello')
        const text = await response.text()
        this.message = text
      } catch (error) {
        console.error('Error fetching message:', error)
        this.message = 'Failed to fetch message'
      }
    }
  }
}
</script>

<style>

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
.regi-btn {
        width: 150%;
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