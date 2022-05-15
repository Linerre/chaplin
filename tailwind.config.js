module.exports = {
  content: [
    "./src/main/**/*.cljs",
    "./src/test/**/*.cljs"],
  theme: {
    extend: {
      lineHeight: {
        'spacious': 3,
      },

      screens: {
        'tb': '680px',
      },

      spacing: {
        '22': '5.5rem',
        'quar' : '25%',
        'half' : '50%',
        'meet' : '60%',
        'triq' : '75%',
        'near' : '90%',
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
          750: '#57068c',
          900: '#433482',
          950: '#2e2459',
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
