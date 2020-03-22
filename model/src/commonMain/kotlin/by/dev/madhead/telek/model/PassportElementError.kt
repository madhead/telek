package by.dev.madhead.telek.model

/**
 * This object represents an error in the Telegram Passport element which was submitted that should be resolved by the user.
 * It should be one of:
 *
 * - [PassportElementErrorDataField]
 * - [PassportElementErrorFrontSide]
 * - [PassportElementErrorReverseSide]
 * - [PassportElementErrorSelfie]
 * - [PassportElementErrorFile]
 * - [PassportElementErrorFiles]
 * - [PassportElementErrorTranslationFile]
 * - [PassportElementErrorTranslationFiles]
 * - [PassportElementErrorUnspecified]
 */
//@Serializable
//@TelegramBotAPIType(type = "passportelementerror")
interface PassportElementError
