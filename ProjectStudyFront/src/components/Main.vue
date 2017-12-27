<template>
  <button type="button" class="btn btn-primary" autocomplate="off" data-loading-text="jquery with bootstrap" @click="clickBtn"/>
</template>
  
<script>
  export default {
    name: 'Main',
    methods: {
      clickBtn(event) {
        $(event.target).button('loading');
        setTimeout(() => {
          $(event.target).button('reset');
        }, 1000);
      },
    },
  };
</script>

<style lang="scss" module>
</style>