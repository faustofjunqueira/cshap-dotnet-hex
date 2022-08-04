using Microsoft.AspNetCore.Mvc.Filters;

namespace Application.Controller.Configuration
{
    public class HttpResponseExceptionFilter : IActionFilter, IOrderedFilter
    {
        public void OnActionExecuting(ActionExecutingContext context)
        {
        }

        public void OnActionExecuted(ActionExecutedContext context)
        {
            // if (context.Exception is HttpException exception)
            // {
            //     context.Result = new ObjectResult(exception.Message)
            //     {
            //         StatusCode = (int) exception.StatusCode,
            //     };
            //     context.ExceptionHandled = true;
            // }
        }

        public int Order { get; } = int.MaxValue - 10;
    }
}