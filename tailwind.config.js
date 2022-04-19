module.exports = {
  content: [
    "./src/main/**/*.cljs",
    "./src/test/**/*.cljs"],
  theme: {
    extend: {
      spacing: {
        '22': '5.5rem',
        'half': '40%'
      },

      rotate: {
        '60' : '60deg',
        '230': '230deg'
      },

      colors: {
        green: {
          750: '#0b7261'
        },
        purple: {
          950: '#2e2459',
          750: '#57068c'
        },
        red: {
          650: '#a72145',
        },
        yellow: {
          450: '#ffc832',
        },
        blue: {
          350: '#4299bf',
        }
      }
    },
  },
  plugins: [],
}
