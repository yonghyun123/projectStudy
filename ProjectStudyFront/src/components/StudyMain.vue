<template>
  <section>
    <study-header></study-header>
    <main>
      Main에는 무엇을 채울까요 ?
    </main>
    <footer></footer>
  </section>
</template>

<script>
const Header = () => import('../components/Header');
export default {
  name: 'StudyMain',
  components: {
    studyHeader: Header,
  },
};
</script>
<style lang="scss" module>
</style>