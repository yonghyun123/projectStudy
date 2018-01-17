<template>
  <section>
    <study-header>
    </study-header>
    <div class="row">
      <div class="col-sm-12">
        <form method="post" enctype="multipart/form-data">
        <div class="form-group">
       </div>
      
        <md-button class="btn btn-primary">
          <i clsss ="fa fa-upload"></i> upload
        </md-button>
        </form>
      </div>
    </div>
     <img :src="imagePreview" class="preview-image" @click="openUpload">
       <input
       name="image"
       type="file"
       id="add-study" 
       @change="updatePreview"
       style="display: none;">
  </section>
  
</template>

<script>
  const Header = () => import('../components/Header');
  export default {
    data() {
      return {
        imagePreview: '../../src/assets/logo.png',
      };
    },
    methods: {
      openUpload() {
        document.getElementById('add-study').click();
      },
      updatePreview(e) {
        let reader = e.target.files;
        const files = e.target.files;

        if (!files) {
          return;
        }
        reader = new FileReader();
        reader.onload = (ea) => {
          console.log('ddd');
          this.imagePreview = ea.target.result;
        };
        reader.readAsDataURL(files[0]);
      },
    },
    components: {
      StudyHeader: Header,

    },
  };
</script>

<style lang="scss" scoped>
img {
  width: 30%;
  margin: auto;
  display: block;
  margin-bottom: 10px;
}
</style>


