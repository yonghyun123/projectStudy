<template>
  <div class="page-container md-layout-column">
    <md-toolbar class="md-accent">
      <md-button class="md-icon-button" @click="showNavigation = true">
        <md-icon>menu</md-icon>
      </md-button>
      <md-button>
        <span class="md-title" @click="routeMain()">공부하자 얘들아</span>
      </md-button>
    </md-toolbar>

    <md-drawer :md-active.sync="showNavigation">
      <md-toolbar class="md-transparent" md-elevation="0" :id="$style.navHeader">
        <span class="md-title">Navigation</span>
      </md-toolbar>

      <md-list>
        <md-list-item :class="$style.listItem " @click="routeStudyProject()">
          <md-icon>account_box</md-icon>
          <span class="md-list-item-text">모임 리스트</span>
        </md-list-item>

        <md-list-item :class="$style.listItem" @click="routeProject()">
          <md-icon>description</md-icon>
          <span class="md-list-item-text">기능 추가</span>
        </md-list-item>

        <md-list-item :class="$style.listItem" @click="routeInput()">
          <md-icon>work</md-icon>
          <span class="md-list-item-text">기능 추가</span>
        </md-list-item>

        <md-list-item :class="$style.listItem" @click="routeEvaluation()">
          <md-icon>assessment</md-icon>
          <span class="md-list-item-text">기능 추가</span>
        </md-list-item>
      </md-list>
    </md-drawer>
  </div>
</template>

<script>
const Component = {
  name: 'Header',
  data() {
    return {
      showNavigation: false,
    };
  },

  methods: {
    routeMain() {
      this.$router.push({ path: '/' });
    },

    routeStudyProject() {
      this.$router.push({ path: '/studymain' });
    },

    routeInput() {
      this.$router.push({ path: 'Input' });
    },

    routeEvaluation() {
      this.$router.push({ path: 'Evaluation' });
    },

    routeProject() {
      this.$router.push({ path: 'ProjectList' });
    },
  },
};

export default Component;
</script>

<style lang="scss" module>
#navHeader {
  border-bottom: 1px solid #d2d2d2;
}

.listItem {
  cursor: pointer;
}

</style>