<template>

  <nav>
      <RouterLink to="/mew/login"/>

      <!-- 여기에 페이지 컴포넌트가 바뀌어 출력됨 -->
      <RouterView />
  </nav>
</template>

<script>

export default {
  name: 'App',
  components: {

  },
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
body {
      height: 100vh; /* 화면 전체 높이 */
      margin: 0;
      display: flex;
      justify-content: center; /* 가로 가운데 */
      align-items: center;     /* 세로 가운데 */
    }

</style>