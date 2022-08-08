using System.Net;
using Core.Exceptions;
using Microsoft.AspNetCore.Mvc;
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
            if (context.Exception is RecordNotFoundException exception)
            {
                context.Result = new ObjectResult(exception.Message)
                {
                    StatusCode = (int)HttpStatusCode.BadRequest
                };
                context.ExceptionHandled = true;
            }
        }

        public int Order { get; } = int.MaxValue - 10;
    }
}