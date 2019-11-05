var app = new Vue({
    el: '#app',
    data: {
        weather: {}
    },
    created() {
        axios
            .get('/weather/london')
            .then(response => (this.weather = response.data))
    },
    methods: {
        onChange(event) {
            axios
                .get('/weather/' + event.target.value)
                .then(response => (this.weather = response.data))
        }
    }
});
