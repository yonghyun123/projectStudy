<template>
  <section>
    <study-header>
    </study-header>
    <div class="row">
      <div class="col-sm-12">
      </div>
    </div>
     <img :src="imagePreview" class="preview-image" @click="openUpload">
       <input
       name="image"
       type="file"
       id="add-study" 
       @change="updatePreview"
       style="display: none;"/>
       <md-button class="btn btn-primary" @click="sendImage">Post</md-button>
  </section>
  
</template>

<script>
  const Header = () => import('../components/Header');
  export default {
    data() {
      return {
        fileData: null,
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
        reader.onload = (el) => {
          this.imagePreview = el.target.result;
        };
        this.fileData = files[0];
        console.log(this.fileData);
        reader.readAsDataURL(files[0]);
      },
      sendImage() {
        const formData = new FormData();
        console.log(this.fileData);
        formData.append('file', this.fileData);
        this.axios.post('http://localhost:8081/projectStudy/test/', formData)
        .then((res) => {
          console.log(res);
        });
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


