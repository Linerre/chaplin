module.exports = {
  content: [
    "./src/main/**/*.cljs",
    "./src/test/**/*.cljs"],
  theme: {
    extend: {
      borderWidth: {
        DEFAULT: '1px',
        '1': '1px',
      },
      lineHeight: {
        'spacious': 3,
      },

      screens: {
        'tb': '680px',
      },
      maxWidth: {
      },
      spacing: {
        '22': '5.5rem',
        'quar' : '25%',
        'thir' : '35%',
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
        slate: {
          25: '#fcfcfc',
          350: '#e5e7eb',
          950: '#2a3439',
        },
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
