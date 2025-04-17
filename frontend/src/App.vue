<template>

  <nav class="main-nav">
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
  height: 100vh;
  margin: 0;
  display: flex;
  justify-content: center;
  align-items: center;
}

.main-nav {
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}


</style>