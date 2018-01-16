<template>
  <div class="page-container md-layout-column">
    <md-toolbar class="md-accent">
      <md-button class="md-icon-button" @click="showNavigation = true">
        <md-icon>menu</md-icon>
      </md-button>
      <md-button>
        <span class="md-title" @click="gotomain()">공부하자 얘들아</span>
      </md-button>
    </md-toolbar>

    <md-drawer :md-active.sync="showNavigation">
      <md-toolbar class="md-transparent" md-elevation="0" :id="$style.navHeader">
        <span class="md-title">Navigation</span>
      </md-toolbar>

      <md-list>
        <md-list-item :class="$style.listItem " @click="routeEmployee()">
          <md-icon>account_box</md-icon>
          <span class="md-list-item-text">직원 리스트</span>
        </md-list-item>

        <md-list-item :class="$style.listItem" @click="routeProject()">
          <md-icon>description</md-icon>
          <span class="md-list-item-text">프로젝트 리스트</span>
        </md-list-item>

        <md-list-item :class="$style.listItem" @click="routeInput()">
          <md-icon>work</md-icon>
          <span class="md-list-item-text">투입 중 직원 보기</span>
        </md-list-item>

        <md-list-item :class="$style.listItem" @click="routeEvaluation()">
          <md-icon>assessment</md-icon>
          <span class="md-list-item-text">직원 평점 보기</span>
        </md-list-item>
      </md-list>
    </md-drawer>
  </div>
</template>

<script>
export default {
  name: 'StudyMain',
  data: () => ({
    showNavigation: false,
  }),
  methods: {
    gotomain() {
      this.$router.push('/');
    },
  },
};
</script>
<style lang="scss" module>
#navHeader {
  border-bottom: 1px solid #d2d2d2;
}

.listItem {
  cursor: pointer;
}

</style>