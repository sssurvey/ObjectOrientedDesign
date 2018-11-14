package responseCode;

public enum StatusCodes {

    BAD_REQUEST {
        public int getCode() {
            return 400;
        }
    },

    NOT_FOUND {
        @Override
        public int getCode() {
            return 404;
        }
    },

    CREATED_OK {
        @Override
        public int getCode() {
            return 201;
        }
    },

    OK {
        @Override
        public int getCode() {
            return 200;
        }
    };

    public int getCode() {
        return 204; // No content OK response
    };
}